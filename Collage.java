
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
        /*public void cropAndCopy(Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, 
  int endSourceCol, int startDestRow, int startDestCol)*/
      canvas.cropAndCopy(squidward, 0, 249, 0,409, 0, 0);  
        canvas.explore();
    }
    
}
