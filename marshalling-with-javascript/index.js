var infinispan = require('infinispan');

var connected = infinispan.client({port: 11222, host: '127.0.0.1'},  {
  dataFormat: {
    keyType: 'application/json'
    , valueType: 'application/json'
  },
  cacheName: 'text-personal-shoppers'
});
connected.then(function(client) {
  console.log("Connected");
  var uuid = generateGuid();
  var putGetPromise = client.put(uuid, {
     'id': uuid,
     'name': "Miren from JS",
     'city': "BILBAO",
  }).then(function () {
    return client.get(uuid).then(function (value) {
      console.log('uuid = ' + uuid)
      console.log('value = ' + JSON.stringify(value));
    })
  });

  return putGetPromise.finally(function() {
    // Regardless of the result, disconnect client
    return client.disconnect().then(function() { console.log("Disconnected") });
  });
});

function generateGuid() {
  var result, i, j;
  result = '';
  for(j=0; j<32; j++) {
    if( j == 8 || j == 12 || j == 16 || j == 20)
      result = result + '-';
    i = Math.floor(Math.random()*16).toString(16).toUpperCase();
    result = result + i;
  }
  return result.toLowerCase();
}
