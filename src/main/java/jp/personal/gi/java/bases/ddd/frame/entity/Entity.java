package jp.personal.gi.java.bases.ddd.frame.entity;

import java.util.Objects;

/**
 * 同一性と等価性、不変性を表現する。
 * <p>
 * 識別子のアクセスと同一性、等価性の確認機能を提供する。
 * </p>
 *
 * @param <T> 識別子の型
 */
public interface Entity<T extends EntityId> {
    /**
     * このインスタンスの識別子を返す。
     *
     * @return 識別子
     */
    T getId();

    /**
     * このインスタンスの識別子が、判定対象の識別子と等価か確認する。
     *
     * @param id 判定対象の識別子
     * @return <p>
     * 等価の場合、true。<br>
     * そうでない場合、false。
     * </p>
     */
    default boolean matches(T id) {
        return Objects.equals(id, this.getId());
    }

    /**
     * このインスタンスの識別子が、判定対象の識別子と不等価か確認する。
     *
     * @param id 判定対象の識別子
     * @return <p>
     * 不等価の場合、true。<br>
     * 等価の場合、false。
     * </p>
     */
    default boolean notMatches(T id) {
        return !matches(id);
    }

    /**
     * このインスタンスと判定対象のインスタンスが同一か確認する。
     *
     * @param other 判定対象のインスタンス
     * @return <p>
     * 同一の場合、true。<br>
     * 不同の場合、false。
     * </p>
     */
    default boolean isSameIdentifierAs(Entity<T> other) {
        return Objects.nonNull(other) && matches(other.getId());
    }

    /**
     * このインスタンスと判定対象のインスタンスが不同か確認する。
     *
     * @param other 判定対象のインスタンス
     * @return <p>
     * 不同の場合、true。<br>
     * 同一の場合、false。
     * </p>
     */
    default boolean notSameIdentifierAs(Entity<T> other) {
        return !isSameIdentifierAs(other);
    }

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
