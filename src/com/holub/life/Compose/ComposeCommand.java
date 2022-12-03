package com.holub.life.Compose;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

public interface ComposeCommand {

    public Collection execute(Collection cell1, Collection cell2) throws IOException;
    String getName();
}
