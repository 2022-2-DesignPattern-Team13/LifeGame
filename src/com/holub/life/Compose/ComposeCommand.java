package com.holub.life.Compose;

import java.io.FileInputStream;

public interface ComposeCommand {

    public FileInputStream execute(FileInputStream[] fileInput);
}
