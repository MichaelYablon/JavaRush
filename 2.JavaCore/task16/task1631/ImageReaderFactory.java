package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

/**
 * Created by Miha on 20.04.2017.
 */
public class ImageReaderFactory {


    public static ImageReader getImageReader(ImageTypes jpg) {
        ImageReader reader;

        if (jpg == ImageTypes.JPG) reader = new JpgReader();
        else if (jpg == ImageTypes.BMP) reader = new BmpReader();
        else if (jpg == ImageTypes.PNG) reader = new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");

        return reader;
    }
}
