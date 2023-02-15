package pethero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pethero.dao.ImagesDAO;
import org.springframework.web.multipart.MultipartFile;
import pethero.domain.Image;
import pethero.domain.ImageUtil;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
@Service
public class ImagesService{

    @Autowired
    private ImagesDAO imagesDAO;

    public Image uploadImage(MultipartFile file) throws IOException {

        Image saved = imagesDAO.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());

        return saved;
    }

    @Transactional
    public Image getInfoByImageById(long id) {
        Optional<Image> dbImage = imagesDAO.findById(id);

        return Image.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();

    }

    @Transactional
    public byte[] getImage(Long id) {
        Optional<Image> dbImage = imagesDAO.findById(id);
        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
        return image;
    }

}
