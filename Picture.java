import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 

{
    private static final Color YELLOW = new Color( 255, 243, 71 );
    private static final Color CYAN = new Color( 157, 254, 225 );
    private static final Color ORANGE = new Color( 255, 89, 0 );
    private static final Color PURPLE = new Color( 167, 86, 255);
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setBlue(0);
            }
        }
    }

    /** Method to keep only the blue in a picture */
    public void keepOnlyBlue()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /** Method to negate all pixels in a picture */
    public void negate()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    /** Method to change a picture to grayscale */
    public void grayscale()
    {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
            for (Pixel pixelObj : rowArray)
            {
                int average = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
                pixelObj.setRed(average);
                pixelObj.setGreen(average);
                pixelObj.setBlue(average);
            }
        }
    }

    /**
     * Posterizes the color of every pixel in the picture to inputted colors and subranges.
     *
     * @param 4 colors to input, and 3 subranges
     */
    public void posterize(Picture srcPic, Color colorToSet1 , Color colorToSet2, Color colorToSet3, Color colorToSet4,double subrange1, double subrange2, double subrange3)
    {
        int width = srcPic.getWidth();
        int height = srcPic.getHeight();

        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = srcPic.getPixel( x, y );
                Color color = pixel.getColor();
                int r = pixel.getRed();
                if (r < subrange1)
                {
                    Color posterize1 = colorToSet1 ;
                    pixel.setColor( posterize1 );
                }
                else if ( r > subrange1 && r<subrange2  ) 
                {
                    Color posterize2 = colorToSet2 ;
                    pixel.setColor( posterize2 );
                }
                else if ( r > subrange2 && r<subrange3  ) 
                {
                    Color posterize3 = colorToSet3 ;
                    pixel.setColor( posterize3 );
                }
                else
                {
                    Color posterize4 = colorToSet4 ;
                    pixel.setColor( posterize4 );
                }
            }
        }
    }

    public void transform()
    {
        //invoked greyscale method on manipulator object
        this.grayscale();
        // finding largest greyscale value
        int width = this.getWidth();
        int height = this.getHeight();
        int max = 0;
        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.getPixel( x, y );
                Color color = pixel.getColor();
                int red = color.getRed();

                if (red > max)
                {
                    max = red;
                }
            }
        }
        //finding smallest greyscale value
        int min = 255;
        for( int y = 0; y < height; y++ )
        {
            for( int x = 0; x < width; x++ )
            {
                Pixel pixel = this.getPixel( x, y );
                Color color = pixel.getColor();
                int red = color.getRed();

                if (red < min)
                {
                    min = red;
                }
            }
        }
        double totalRange = max-min;
        double subrange1 = (totalRange)/(4);
        double subrange2 = subrange1 * 2;
        double subrange3 = subrange1 * 3;        
        this.posterize(this, PURPLE, ORANGE, CYAN,YELLOW, subrange1, subrange2, subrange3);

    }

    public void cropAndCopy(Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, 
    int endSourceCol, int startDestRow, int startDestCol){

        Pixel[][] originalImage = this.getPixels2D();
        Pixel[][] inputtedImage = sourcePicture.getPixels2D();

        Pixel original = null;
        Pixel changed = null;
        int c = 0;
        int r = 0;

        for (int row=startSourceRow; row < endSourceRow;row++){
            for (int col=startSourceCol; col<endSourceCol; col++){
                original = originalImage[r+startDestRow][c+startDestCol];
                changed = inputtedImage[row][col];
                original.setColor(changed.getColor());
                c++;

            }
            r++;
            c=0;
        }

    }
    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        } 
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from right to left */
    public void mirrorVerticalRightToLeft()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; col < width / 2; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    public void mirrorHorizontal(){
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height/2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height-1-row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    public void mirrorHorizontalBotToTop()
    {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int height = pixels.length;
        for (int row = 0; row < height/2; row++)
        {
            for (int col = 0; col < pixels[0].length; col++)
            {
                topPixel = pixels[row][col];
                bottomPixel = pixels[height-1-row][col];
                topPixel.setColor(bottomPixel.getColor());
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++)
            {

                leftPixel = pixels[row][col];      
                rightPixel = pixels[row]                       
                [mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
            for (int col = 0; 
            col < pixels[0].length-1; col++)
            {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col+1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
                    leftPixel.setColor(Color.BLACK);
                else
                    leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();

    }

} // this } is the end of class Picture, put all new methods before this
