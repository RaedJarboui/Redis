Redis is in memory data store, key value store = write and read operations are much faster from caching redis instead mouch database based in disk

Spring Data Redis : directly interact with redis databse without much code as interaction

->to connect to redis, we need dependency jedis

we use redis to improve of our app : imagine having multiple requests to DB, it will take much time to have result

Cahing mechanism : at first request to DB ,all data will go to redis cache, so if we trigger 2nd request->take data from cache not db

@CacheEvict : delete record from DB and want to update it in cache

@CachePut : update smth in DB and reflect it in cache

@Cacheable : use in case of get
