package jp.personal.gi.java.bases.ddd.frame.entity;

/**
 * {@link jp.personal.gi.java.bases.ddd.frame.entity.Entity Entity}の識別子
 */
public interface EntityId {
    /**
     * このインスタンスのハッシュコードを返す。
     *
     * @return ハッシュコード
     */
    @Override
    int hashCode();

    /**
     * このインスタンスが判定対象のインスタンスと等価か確認する。
     *
     * @param o 判定対象のインスタンス
     * @return <p>
     * 等価の場合、true。<br>
     * 不等価の場合、false。
     * </p>
     */
    @Override
    boolean equals(Object o);

    /**
     * このインスタンスの文字列表現を返す。
     *
     * @return 文字列表現
     */
    @Override
    String toString();
}
