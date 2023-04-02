### A very simple Spring reactive API.

API endpoint with the new reactive support in Spring 5 that simply return/emit one very simple resource every second.

### Test

```shell
curl -H "produces:text/event-stream" http://localhost:8080/sse-server/stream-foo'
```

