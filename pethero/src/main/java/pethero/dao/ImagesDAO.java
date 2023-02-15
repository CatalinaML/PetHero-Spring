package pethero.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pethero.domain.Image;

import java.util.Optional;

public interface ImagesDAO extends JpaRepository<Image, Long> {
}
