package pethero.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pethero.dao.ImagesDAO;
import org.springframework.web.multipart.MultipartFile;
import pethero.domain.Image;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;
@Service
public class ImagesService{

    @Autowired
    private ImagesDAO imagesDAO;

    public Image uploadImage(MultipartFile file) throws IOException {
        return imagesDAO.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(file.getBytes()).build());
    }

    @Transactional
    public Image getInfoByImageById(long id) {
        Optional<Image> dbImage = imagesDAO.findById(id);
        return dbImage.map(image -> Image.builder()
                .name(image.getName())
                .type(image.getType())
                .imageData(image.getImageData()).build()).orElse(null);
    }

    @Transactional
    public byte[] getImage(Long id) {
        Optional<Image> dbImage = imagesDAO.findById(id);
        if(dbImage.isPresent()) {
            return dbImage.get().getImageData();
        }
        return new byte[0];
    }

}
