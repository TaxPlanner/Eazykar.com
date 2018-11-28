package com.easykar.rest.upload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<UploadFiles, Long> {
    UploadFiles findByUserID(Long Id);
}
