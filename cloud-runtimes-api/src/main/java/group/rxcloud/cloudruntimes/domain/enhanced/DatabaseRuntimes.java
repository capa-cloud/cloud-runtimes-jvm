package group.rxcloud.cloudruntimes.domain.enhanced;

import group.rxcloud.cloudruntimes.domain.enhanced.database.*;
import group.rxcloud.cloudruntimes.utils.TypeRef;
import reactor.core.publisher.Mono;

public interface DatabaseRuntimes {

    // TODO: 2021/10/12 API
    // see https://github.com/dapr/dapr/issues/3354

    // -- Database Base Operation API

    /**
     * The Creating Connection maybe be inited by Component initialization，and the parameters of Creating Connection
     * comes from yaml metadata. But when we need to create multiple databases, we should create different database
     * connections. This is the reason why we need add Creating Connection API that the app can invoke many times to
     * create multiple connections.
     * If the app developer don't have requirement of multiple database connections, the app developer can ignore this
     * API but use the yaml file to init the database connection.
     */
    Mono<GetConnectionResponse> getConnection(GetConnectionRequest req);

    /**
     * Maybe dapr will be used in some application that is responsible for managing the database, so we will add the
     * creating table API to support it.
     */
    Mono<CreateTableResponse> createTable(CreateTableRequest req);

    /**
     * The reason need this api is the same as Create Table.
     */
    Mono<DeleteTableResponse> deleteTable(DeleteTableRequest req);

    // -- CURD API

    /**
     * The insert API with SQL
     */
    Mono<InsertResponse> insert(InsertRequest req);

    /**
     * The insert API with ORM
     */
    Mono<InsertResponse> insert(String dbName, String tableName, Object data);

    /**
     * The query API with SQL
     */
    <T> Mono<QueryResponse<T>> query(QueryRequest req, TypeRef<T> type);

    /**
     * The query API with ORM
     */
    <T> Mono<QueryResponse<T>> query(String dbName, String tableName, Object data, TypeRef<T> type);

    /**
     * The update API and delete API will be used with SQL.
     */
    Mono<UpdateResponse> update(UpdateRequest req);

    /**
     * The update API and delete API will be used with ORM.
     */
    Mono<UpdateResponse> update(String dbName, String tableName, Object data);

    // TODO: 2021/10/12 TODO
    // -- Database Transaction Operation API

    Mono<Void> BeginTransaction();

    Mono<Void> UpdateTransaction();

    Mono<Void> QueryTransaction();

    Mono<Void> CommitTransaction();

    Mono<Void> RollbackTransaction();
}
