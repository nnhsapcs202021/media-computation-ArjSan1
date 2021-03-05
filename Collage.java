
/**
 * Write a description of class Collage here.
 *
 * @ArjSan1
 * @3/3/2021 (a version number or a date)
 */
public class Collage
{
    public static void main(String[] args)
    {
        Picture canvas = new Picture(818,498);
        Picture squidward = new Picture("squidward.jpg");
        Picture squidward2 = new Picture("squidward.jpg");
        Picture squidward3 = new Picture("squidward.jpg");
        Picture squidward4 = new Picture("squidward.jpg");
        squidward.transform();
        squidward2.mirrorHorizontalBotToTop();
        squidward3.grayscale();
        squidward4.edgeDetection(20);
        /*public void cropAndCopy(Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, 
  int endSourceCol, int startDestRow, int startDestCol)*/
    //squidward.explore();
      canvas.cropAndCopy(squidward, 0, 409, 0,248, 0, 0);  
      canvas.cropAndCopy(squidward2, 0, 409, 0, 248, 409, 0); 
      canvas.cropAndCopy(squidward3, 0, 409, 0, 248, 0, 248); 
            canvas.cropAndCopy(squidward4, 0, 409, 0, 248, 409, 248); 


        canvas.explore();
    }
    
}
