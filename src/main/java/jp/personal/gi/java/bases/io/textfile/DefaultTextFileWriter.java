package jp.personal.gi.java.bases.io.textfile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.List;

/**
 * {@link jp.personal.gi.java.bases.io.textfile.TextFileWriter TextFileWriter}のデフォルト実装。
 */
public class DefaultTextFileWriter implements TextFileWriter {
    @Override
    public void write(Path path,
                      List<String> rows,
                      Charset charset,
                      OpenOption... openOptions) throws IOException {
        Files.write(path,
                rows,
                charset,
                openOptions);
    }
}
