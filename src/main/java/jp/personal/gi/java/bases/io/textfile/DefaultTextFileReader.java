package jp.personal.gi.java.bases.io.textfile;

import jp.personal.gi.java.bases.type.maybe.list.ReadOnlyList;
import jp.personal.gi.java.bases.type.maybe.either.Either;
import jp.personal.gi.java.bases.io.RuntimeIOException;

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
    public Either<RuntimeIOException, ReadOnlyList<String>> read(Path path, Charset charset) {
        try {
            final List<String> rows = Files.readAllLines(path, charset);
            return Either.right(null);
        } catch (IOException e) {
            return Either.left(new RuntimeIOException(e));
        }
    }
}
