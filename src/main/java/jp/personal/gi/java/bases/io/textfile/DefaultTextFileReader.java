package jp.personal.gi.java.bases.io.textfile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * {@link jp.personal.gi.java.bases.io.textfile.TextFileReader TextFileReader}のデフォルト実装。
 */
public class DefaultTextFileReader implements TextFileReader {
    @Override
    public List<String> read(Path path, Charset charset) throws IOException {
        return Files.readAllLines(path, charset);
    }
}
