package com.easykar.rest.upload;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.easykar.rest.userprofile.ResponseProfileSuccess;

@Controller
@RequestMapping(value = { "/file" })
public class FileUploadController {
    
    private static String UPLOADED_FOLDER = "//home//manoj//upload//";
    
    @Autowired
    UploadFileService uploadFileService;
    
    @Autowired
    DocumentsService documentsService;
    
    @RequestMapping(value = "/upload", method = RequestMethod.POST, produces = { "application/json", "application/xml" }, consumes = {
            "application/json",
            "application/xml" })
    public ResponseEntity<?> uploadFiles(@RequestParam MultipartFile files) {
        ResponseProfileSuccess regRes = new ResponseProfileSuccess();
        File dir = new File(UPLOADED_FOLDER);
        String status = "";
        
        try {
            byte[] bytes = files.getBytes();
            
            if (!dir.exists()) {
                dir.mkdirs();
            }
            
            File uploadFile = new File(dir.getAbsolutePath() + File.separator + files.getOriginalFilename());
            BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(uploadFile));
            outputStream.write(bytes);
            outputStream.close();
            
            status = status + "You successfully uploaded file=" + files.getOriginalFilename();
            System.out.println(status);
            regRes.setResponse_code("1");
            regRes.setResponse_msg("Files have been uploaded successfully");
            return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
        } catch (Exception e) {
            status = status + "Failed to upload " + files.getOriginalFilename() + " " + e.getMessage();
            regRes.setResponse_code("0");
            regRes.setResponse_msg("Failed to upload");
            return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
        }
        
    }
    
    @RequestMapping(value = "/savefile", method = RequestMethod.POST, produces = { "application/json", "application/xml" }, consumes = {
            "application/json",
            "application/xml" })
    public ResponseEntity<?> saveFile(@RequestBody UploadFiles files) {
        ResponseProfileSuccess regRes = new ResponseProfileSuccess();
        boolean isSave = uploadFileService.save(files);
        if (isSave) {
            regRes.setResponse_code("1");
            regRes.setResponse_msg("Files have been saved successfully");
            return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
        } else {
            regRes.setResponse_code("0");
            regRes.setResponse_msg("Failed");
            return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
        }
    }
    
    @RequestMapping(value = "/savedocs", method = RequestMethod.POST, produces = { "application/json", "application/xml" }, consumes = {
            "application/json",
            "application/xml" })
    public ResponseEntity<?> savepasswordFile(@RequestBody Documents files) {
        ResponseProfileSuccess regRes = new ResponseProfileSuccess();
        boolean isSave = documentsService.save(files);
        if (isSave) {
            regRes.setResponse_code("1");
            regRes.setResponse_msg("Files have been saved successfully");
            return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
        } else {
            regRes.setResponse_code("0");
            regRes.setResponse_msg("Failed");
            return new ResponseEntity<ResponseProfileSuccess>(regRes, HttpStatus.CREATED);
        }
    }
}
