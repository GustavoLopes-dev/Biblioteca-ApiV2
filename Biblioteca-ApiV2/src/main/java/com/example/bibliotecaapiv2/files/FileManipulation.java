package com.example.bibliotecaapiv2.files;


import java.io.IOException;

public interface FileManipulation {
    void reader() throws IOException;

    void writer() throws IOException;

    void delete() throws IOException;
}
