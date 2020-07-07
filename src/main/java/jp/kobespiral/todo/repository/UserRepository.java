package jp.kobespiral.todo.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jp.kobespiral.todo.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    //user名でとってくる
    public User findUserByNameLike(String uid);

    //全部のuserをとってくる
    public Iterable<User> findAll();

    // // 以下，カスタムクエリ
    //  /**
    //  * 名前で検索
    //  * @param name 検索する名前・LIKEで検索 "%中村%"
    //  * @return
    //  */
    // public Iterable<Person> findPersonByNameLike(String name);

    // /**
    //  * 身長で検索
    //  * @param min 最小値
    //  * @param max 最大値
    //  * @return
    //  */
    // public Iterable<Person> findPersonByHeightBetween(double min, double max);

    // /**
    //  * 体重で検索
    //  * @param min 最小値
    //  * @param max 最大値
    //  * @return
    //  */
    // public Iterable<Person> findPersonByWeightBetween(double min, double max);
    

    // /**
    //  * 生まれ月で検索
    //  * @param month 生まれ月
    //  * @return
    //  */
    // @Query(value = "SELECT * FROM Person p where MONTH(p.birthday) = ?1",  nativeQuery = true)
    // public Iterable<Person> findPersonByMonth(int month);


}