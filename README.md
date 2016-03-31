# SimplePoll
A JEE web application for creating online polls.

## Use
+ Eclipse for Java EE with _GlassFish Tools_
+ GlassFish 4
+ In GlassFish 4 server admin page:
  + Create a JDBC Connection Pool
  + Create a JDBC Resource `simplepoll` using the created poll
+ In Eclipse _Data Source Explorer_:
  + Create a new database connection with the details used above
  + Configure the persistence unit in _persistence.xml_:
  ````
<persistence-unit name="simplepoll">
		<jta-data-source>jdbc/simplepoll</jta-data-source>
		<properties>
			<property name="eclipselink.ddl-generation" value="drop-and-create-tables" />
		</properties>
	</persistence-unit>
```

## API
All data is sent and received in JSON.

| METHOD | Endpoint          | Returns   |
|--------|:------------------|-----------|
| `GET`  | `/api/polls/{id}` | `poll`    |

## Screenshots
### Create a poll
![](http://i.imgur.com/4kSzJ3i.png)
### Vote on a poll
![](http://i.imgur.com/8zK4v7S.png)
### View the results of a poll
![](http://i.imgur.com/KMXTNyh.png)
