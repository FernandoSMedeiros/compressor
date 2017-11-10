package clases;

import java.io.*;
import java.util.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;

public class Compressor {

    File imagemOriginal = null;
    File imagemComprimida = null;

    String nomeArquivoSaida = "compress.jpg";
    
    float qualidadeSaida = 0.5f;

    public Compressor(File image) {
        this.imagemOriginal = image;
    }

    public void comprimir() throws IOException {

        BufferedImage image = ImageIO.read(this.imagemOriginal);

        this.imagemComprimida = new File(nomeArquivoSaida);
        OutputStream os = new FileOutputStream(imagemComprimida);

        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        ImageWriter writer = (ImageWriter) writers.next();

        ImageOutputStream ios = ImageIO.createImageOutputStream(imagemComprimida);
        writer.setOutput(ios);

        ImageWriteParam param = writer.getDefaultWriteParam();

        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(qualidadeSaida);        
        
        writer.write(null, new IIOImage(image, null, null), param);

        os.close();
        ios.close();
        writer.dispose();

    }

}
