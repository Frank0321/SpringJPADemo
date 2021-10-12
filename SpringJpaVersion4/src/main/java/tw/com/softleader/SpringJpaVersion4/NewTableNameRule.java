package tw.com.softleader.SpringJpaVersion4;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

/**
 * FileName : NewTableNameRule
 * CreatTime : 2021/10/13
 * Author : Frank
 * Description : 建立所有 Entity 的規則，且需要在 application.properties 內設定
 */
public class NewTableNameRule extends SpringPhysicalNamingStrategy {

    private static final String TABLE_PREFIX = "NEW_";

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        Identifier identifier = super.toPhysicalTableName(name, jdbcEnvironment);
        return new Identifier(TABLE_PREFIX + identifier.getText(), identifier.isQuoted());
    }

    @Override
    protected Identifier getIdentifier(String name, boolean quoted, JdbcEnvironment jdbcEnvironment) {
        String identifiter = name.replace("ENTITY", "");
        return new Identifier(identifiter, quoted);
    }
}
