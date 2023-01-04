package com.eight.springData.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eight.springData.files.entities.Image;
import com.eight.springData.files.repos.ImageRepository;

@SpringBootTest
class FileDataApplicationTests {
	
	@Autowired
	ImageRepository imageRepo;

	@Test
	public void testImageSave() throws IOException {
		Image image = new Image();
		image.setId(1);
		image.setName("pic.png");
		
		File file = new File("C:\\Users\\visha\\Pictures\\Untitled.png");
		byte[] fileContent = new byte[(int)file.length()];
		FileInputStream inputStream = new FileInputStream(file);
		inputStream.read(fileContent);   //This method adds file image to byte[] fileContent
		image.setData(fileContent);
		
		
		imageRepo.save(image);
		
		inputStream.close();
	}

}
