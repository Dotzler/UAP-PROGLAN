package org.example.cbuap;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReadExample extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Membuat objek TextArea untuk menampilkan teks dari file
        TextArea textArea = new TextArea();

        // Memanggil metode untuk membaca isi file teks dan menampilkannya di TextArea
        readTextFile("path/to/your/textfile.txt", textArea);

        // Membuat objek Scene
        Scene scene = new Scene(textArea, 400, 300);

        // Mengatur judul stage
        primaryStage.setTitle("JavaFX Read Text File Example");

        // Menetapkan scene pada stage
        primaryStage.setScene(scene);

        // Menampilkan stage
        primaryStage.show();
    }

    private void readTextFile(String filePath, TextArea textArea) {
        // Membuat objek File dengan path file yang diinginkan
        File file = new File(filePath);

        // Menggunakan try-with-resources untuk otomatis menutup BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();

            // Membaca setiap baris dari file dan menambahkannya ke StringBuilder
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Menetapkan teks dari StringBuilder ke TextArea
            textArea.setText(content.toString());
        } catch (IOException e) {
            e.printStackTrace();
            textArea.setText("Error reading the file.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
