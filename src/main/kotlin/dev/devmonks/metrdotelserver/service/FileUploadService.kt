package dev.devmonks.metrdotelserver.service

import com.google.auth.oauth2.GoogleCredentials
import com.google.cloud.storage.Acl
import com.google.cloud.storage.Blob
import com.google.cloud.storage.BlobInfo
import com.google.cloud.storage.Storage
import com.google.cloud.storage.StorageOptions.newBuilder
import org.springframework.http.codec.multipart.FilePart
import org.springframework.stereotype.Service
import java.io.File

@Service
class FileUploadService {
    val bucketString: String = "metrdotel.appspot.com"
    val storage: Storage = newBuilder().setCredentials(GoogleCredentials.getApplicationDefault()).build().service

    fun imageUpload(file: FilePart, type: String): String? {
        val contentType: String? = file.headers().getFirst("content-type")
        val fileName: String = file.filename()
        val split: List<String> = fileName.split(".")
        val actualFile: File = createTempFile(prefix = split[0], suffix = ".${split[1]}")
        file.transferTo(actualFile)
        val build: BlobInfo = BlobInfo.newBuilder(bucketString, "${type}/${fileName}").setAcl(ArrayList<Acl>(listOf(Acl.of(Acl.User.ofAllUsers(), Acl.Role.OWNER)))).setContentType(contentType).build()
        val blob: Blob = storage.createFrom(build, actualFile.inputStream())
        actualFile.deleteOnExit()
        return blob.selfLink
    }
}
