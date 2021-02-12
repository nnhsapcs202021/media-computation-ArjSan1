Collage Lab

# Introduction

The goal of this lab is for you to apply creatively the filters and transformations that you have developed throughout this unit.

# Requirements

* commit to GitHub, at least daily, with a meaningful commit message describing what you accomplished and what needs to be done next

* create a new class, Collage, with a static main method that will create the collage

* collage contains at least 4 copies of the image

* the 4 copies includes the original image and at least 3 modifications of the original image

    * you may find it convenient to start with a large, blank picturePicture canvas = new Picture(height, width);

    * you must invoke the cropAndCopy method that you wrote in the previous programming activity

    * demonstrate your program that displays a picture combining 4 unmodified copies of the original image to your instructor before adding filters or transformations

* modifications must include one or more filters (changing colors) **that you implemented** and one or more transformations (scaling, mirroring) **that you implemented**

* the collage must be saved as an image file, by default it will be saved in the images folder:

    * canvas.write("YourName.jpg");

    * this code doesn't work for some students for unknown reasons. You may need to specify an absolute path. For example on Windows:

        * canvas.write("C:\\Users\\gschmit\\GitHub\\media-computation-gcschmit\\PictureLab\\images\\Schmit.jpg");

    * on Mac:

        * canvas.write("/Users/gschmit/Documents/GitHub/media-computation-gcschmit/PictureLab/images/Schmit.jpg");

# Extensions

* Add more copies.

* Add more filters

    * sepia:

        * convert to grayscale

        * if red < 60 then reduce all three components to 90% of their original value

        * else if red < 190 then reduce just blue to 80% of its original value

        * else reduce just blue to 90% of its original value

    * posterize

        * set all color component values in a range to one value (the midpoint of the range)

        * try with four ranges for each color (0-63, 64-127, 128-191, 192-255)

    * customizable posterize

        * posterize with parameter that specifies how many bins to create (try 8 colors)

    * edge detection

        * calculate the average color for the current pixel and the pixel at the same x but y+1 (Pixel has a getAverage method)

        * get the distance between the two averages

        * if the absolute value of the distance is greater than some value, then turn the current pixel black (Pixel has a colorDistance method) otherwise, turn the current pixel white

    * edge detection 2

        * edge detection but with calculation based on pixel to the right

    * pixelate

    * [voronoi polygons and random points](https://drive.google.com/file/d/13pYbVYMJToOipdS9bwc6YThK5kagBtUD/view?usp=sharing)

    * [sine wave filter](https://drive.google.com/file/d/1hKnDnMWpJpUsunjZRKZ3ER6xqhM5uFH3/view?usp=sharing) ([sample code](https://www.openprocessing.org/sketch/548806) in Processing)

    * [seam carving transformation](https://cestlaz.github.io/post/seam-carving/) ([more](http://nifty.stanford.edu/2015/hug-seam-carving/))

    * [geometric primitives](https://github.com/fogleman/primitive/blob/master/README.md) (warning: this is crazy hard but looks awesome)

    * read the paper, "[A Neural Algorithm of Artistic Style](https://arxiv.org/pdf/1508.06576.pdf)" and browse the [associated code](https://github.com/jcjohnson/neural-style)

* Add more transformations

    * 90° rotation

    * arbitrary rotation

    * [geometric inversion](https://docs.google.com/document/d/1LLXkcaz9A7nKWhp8P_abr-KcDImhGIXFGS1qbT9DvM8/edit?ts=5a561f43) (way cool math here)

* Add More Awesome.

# Submission

* Submit a link to your GitHub repository with this assignment.

* If you would like your Collage Lab featured on the school TVs, take a screenshot of your image and add it to the [shared Google slide deck](https://docs.google.com/presentation/d/1TbO8HtcZUeIVIzkE-67SrHijQlaJQIjKrpRvVQ922Ps/edit?usp=sharing) based on the provided template slide.


https://docs.google.com/document/d/1oPe7VFaIeuUYPd_ZQPgGODLHjqAIpo8jLvWXW7DNSEc/edit
