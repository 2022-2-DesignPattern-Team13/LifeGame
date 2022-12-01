package com.holub.life.Compose;

import java.io.FileInputStream;
import java.io.IOException;

public interface ComposeCommand {

    public FileInputStream execute(FileInputStream[] fileInput) throws IOException;
}
