# soap-client-with-cxf-using-play

[![Build Status](https://travis-ci.org/damienbeaufils/soap-client-with-cxf-using-play.svg?branch=master)](https://travis-ci.org/damienbeaufils/soap-client-with-cxf-using-play)
[![Heroku](https://heroku-badge.herokuapp.com/?app=cxf-soap-client-using-play&root=cities/France&style=flat&svg=1)](https://cxf-soap-client-using-play.herokuapp.com/cities/France)

Implementing a SOAP client with CXF using Play Framework 2.5.x

## Step by step tutorial

See https://damienbeaufils.dev/blog/implementing-a-soap-client-with-cxf-using-play-framework-2-x/

## How to run it

```
bin/activator run
curl http://localhost:9000/cities/France
curl http://localhost:9000/weather/France/Cognac
```

## Live demo

* List of France cities: https://cxf-soap-client-using-play.herokuapp.com/cities/France
* Current weather in Cognac, France: https://cxf-soap-client-using-play.herokuapp.com/weather/France/Cognac
