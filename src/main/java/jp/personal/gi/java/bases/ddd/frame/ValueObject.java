package jp.personal.gi.java.bases.ddd.frame;

/**
 * 不変性と等価性を表現する。
 * <p>
 * 等価性の確認機能を提供する。
 * </p>
 */
public interface ValueObject {

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
