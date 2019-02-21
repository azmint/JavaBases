package jp.personal.gi.java.bases.io.textfile;

import jp.personal.gi.java.bases.type.maybe.list.ReadOnlyList;
import jp.personal.gi.java.bases.type.maybe.either.Either;
import jp.personal.gi.java.bases.io.RuntimeIOException;

import java.nio.charset.Charset;
import java.nio.file.Path;

/**
 * テキストファイル読み込み機能
 */
@FunctionalInterface
public interface TextFileReader {
    Either<RuntimeIOException, ReadOnlyList<String>> read(Path path, Charset charset);
}
