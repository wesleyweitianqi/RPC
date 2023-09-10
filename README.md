# RPC
Implements zookeeper server and RMI to obtain RPC 

# Run ZooKeeper in docker 
`docker run --name zookeeper1 --restart always -p 2182:2182 -d zookeeper`

## get all znode in zookeeper
`ls /`

## get all stats from znode
`get -s /node`

