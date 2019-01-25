package jp.personal.gi.java.bases.io.textfile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

/**
 * テキストファイルの書き込み機能
 */
@FunctionalInterface
public interface TextFileWriter {
    /**
     * テキスト行をファイルに書き込む。
     *
     * @param path        パス
     * @param rows        テキスト行
     * @param charset     文字コード
     * @param openOptions ファイルを開く方法を指定するオプション
     * @throws IOException 書き込みに失敗した場合
     */
    void write(Path path,
               List<String> rows,
               Charset charset,
               OpenOption... openOptions) throws IOException;

    /**
     * オブジェクトリストをテキスト行に変換して、ファイルに書き込む。
     * @param path パス
     * @param rows オブジェクトリスト
     * @param charset 文字コード
     * @param openOptions ファイルを開く方法を指定するオプション
     * @throws IOException 書き込みに失敗した場合
     */
    default void writeObject(Path path,
                             List<Object> rows,
                             Charset charset,
                             OpenOption... openOptions) throws IOException {
        this.write(path,
                rows.stream()
                        .map(Object::toString)
                        .collect(Collectors.toList()),
                charset,
                openOptions);
    }
}
