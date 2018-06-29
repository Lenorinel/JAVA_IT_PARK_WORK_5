package ru.itpark.service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itpark.service.models.FileInfo;

import java.util.Optional;

public interface FileInfosRepository extends JpaRepository<FileInfo, Long> {
    Optional<FileInfo> findOneByStorageFileName(String storageFileName);
}
