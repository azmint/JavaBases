package jp.personal.gi.java.bases.io.textfile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.List;

/**
 * テキストファイル読み込み機能
 */
@FunctionalInterface
public interface TextFileReader {
    /**
     * テキストファイルを読み込み、で返す。
     *
     * @param path パス
     * @param charset 文字コード
     * @return ファイルの各行を要素にもつ、{@link java.util.Collections#unmodifiableList(List)}を返す。
     * @throws IOException ファイル読み込み時に例外が発生した場合
     */
    List<String> read(Path path, Charset charset) throws IOException;
}
