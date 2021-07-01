package tw.com.softleader.SpringJpaVersion2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> , JpaSpecificationExecutor<UserEntity> {

    /**
     * 使用了 JPA 的 dependency 後，一定要綁一個 DB (如 H2)
     */
    /*
    private void rule(){
        //命名規則
        //https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#jpa.query-methods.query-creation
        //6.3.2 Query Creation
        //如果使用簡單的 SQL 就可以解決的問題 (交易系統 80% 皆可使用這類方法)
    }
    Collection<EmpolyEntity> findByNameAndAgeOrderByName(EmpolyEntity empolyEntity, int age);
    //等同於 SQL 的 where name = "xxx" and age = "ooo" order by name;
    //如果有寫錯，Spring 則無法啟動

    //select * from table where name = 'xxx' and id in ('aaa', 'bbb')
    Collection<EmpolyEntity> findByNameAAndIdIn (String name, Collection<Long> ids);

    Collection<EmpolyEntity> findEmpolyEntitiesByNameAndIdIn (String name, Collection<Long> ids);

    @Query(nativeQuery = true, value = "select  abc from ...:id")
    Collection<EmpolyEntity> userQuery (EmpolyEntity empolyEntity, @Param("id") Long id);
    //在 Entity 已經將 name欄位命名為abc (因為 nativeQuery = true )

    @Query(nativeQuery = true, value = "select  abc from ...?1... ?2")
    Collection<EmpolyEntity> userQuery2 (String name, int age);
    //1 會帶入 name
    //2 會帶入 age
    //ref : https://matthung0807.blogspot.com/2018/06/jpa-jpql.html
    //nativeQuery 節定你使用哪一個語法，使用方法名稱，還是使用 @Query 的

     */

}
