package jp.personal.gi.java.bases.queue;

import jp.personal.gi.java.bases.io.RuntimeIOException;
import jp.personal.gi.java.bases.io.log.Logger;
import jp.personal.gi.java.bases.io.log.MyLogLevel;
import jp.personal.gi.java.bases.io.textfile.TextFileReader;
import jp.personal.gi.java.bases.io.textfile.TextFileWriter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FileQueue implements Queue<String> {
    private final Path path;
    private final Charset charset;
    private final TextFileReader textFileReader;
    private final TextFileWriter textFileWriter;
    private final Logger logger;

    private FileQueue(Path path, Charset charset, TextFileReader textFileReader, TextFileWriter textFileWriter, Logger logger) {
        this.path = path;
        this.charset = charset;
        this.textFileReader = textFileReader;
        this.textFileWriter = textFileWriter;
        this.logger = logger;
    }

    public static FileQueue of(Path path, TextFileReader textFileReader, TextFileWriter textFileWriter, Logger logger) {
        return new FileQueue(path, StandardCharsets.UTF_8, textFileReader, textFileWriter, logger);
    }

    @Override
    public boolean push(String element) {
        try {
            this.textFileWriter.write(
                    this.path,
                    Collections.singletonList(element),
                    this.charset,
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            this.logger.addLine(MyLogLevel.TRACE,
                    String.join(",",
                            "要素をPushしました。",
                            "element=[" + element + "]"));
            return true;
        } catch (IOException e) {
            throw new RuntimeIOException(
                    String.join(",",
                            "要素のPushに失敗しました。",
                            "element=[" + element + "]",
                            "path=[" + this.path + "]",
                            "charset=[" + this.charset + "]"),
                    e);
        }
    }

    @Override
    public Optional<String> pop() {
        try {
            final List<String> rows = this.textFileReader.read(this.path, this.charset);
            final int size = rows.size();
            final long skipCount = size > 0L ? size - 1L : 0L;
            this.textFileWriter.write(
                    this.path,
                    rows.stream()
                            .skip(skipCount)
                            .collect(Collectors.toList()),
                    this.charset);
            return rows.stream().findFirst();
        } catch (IOException e) {
            throw new RuntimeIOException(
                    String.join(",",
                            "ポップに失敗しました。",
                            "path=[" + path + "]",
                            "charset=[" + charset + "]"),
                    e);
        }
    }

    @Override
    public Optional<String> head() {
        try {
            final List<String> rows = this.textFileReader.read(this.path, this.charset);
            return rows.stream().findFirst();
        } catch (IOException e) {
            throw new RuntimeIOException(
                    String.join(",",
                            "先頭要素の取得に失敗しました。",
                            "path=[" + path + "]",
                            "charset=[" + charset + "]"),
                    e);
        }
    }

    @Override
    public Optional<String> tail() {
        try {
            final List<String> rows = this.textFileReader.read(this.path, this.charset);
            final int size = rows.size();
            final long skipCount = size > 0L ? size - 1L : 0L;
            return rows.stream()
                    .skip(skipCount)
                    .findFirst();
        } catch (IOException e) {
            throw new RuntimeIOException(
                    String.join(",",
                            "先頭要素の取得に失敗しました。",
                            "path=[" + path + "]",
                            "charset=[" + charset + "]"),
                    e);
        }
    }

    @Override
    public boolean deleteHead() {
        try {
            final List<String> rows = this.textFileReader.read(this.path, this.charset);
            final int size = rows.size();
            final long skipCount = size > 0L ? size - 1L : 0L;
            this.textFileWriter.write(
                    this.path,
                    rows.stream()
                            .skip(skipCount)
                            .collect(Collectors.toList()),
                    this.charset);
            return true;
        } catch (IOException e) {
            throw new RuntimeIOException(
                    String.join(",",
                            "先頭要素の削除に失敗しました。",
                            "path=[" + path + "]",
                            "charset=[" + charset + "]"),
                    e);
        }
    }

    @Override
    public List<String> toList() {
        try {
            return Collections.unmodifiableList(this.textFileReader.read(this.path, this.charset));
        } catch (IOException e) {
            throw new RuntimeIOException(
                    String.join(",",
                            "要素の取得に失敗しました。",
                            "path=[" + path + "]",
                            "charset=[" + charset + "]"),
                    e);
        }
    }

    @Override
    public String toString() {
        return "FileQueue{" +
                "path=" + path +
                ", charset=" + charset +
                ", textFileReader=" + textFileReader +
                ", textFileWriter=" + textFileWriter +
                ", logger=" + logger +
                '}';
    }
}
