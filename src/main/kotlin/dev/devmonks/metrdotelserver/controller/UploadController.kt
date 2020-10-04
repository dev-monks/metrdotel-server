package dev.devmonks.metrdotelserver.controller

import dev.devmonks.metrdotelserver.service.FileUploadService
import org.springframework.http.MediaType
import org.springframework.http.codec.multipart.FilePart
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RestController

@RestController
class UploadController(val fileUploadService: FileUploadService) {

    @PostMapping("/test/upload_file", consumes = [MediaType.MULTIPART_FORM_DATA_VALUE])
    fun testFileUpload(@RequestPart("file") filePart: FilePart): String? {
        return this.fileUploadService.imageUpload(file = filePart, type = "profile_picture")
    }
}
