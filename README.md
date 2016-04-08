####psjavaplatworkjdbc
#####Peforming badic CRUD
######Understanding Scrollable ResultSets
Two params:
```
1) ResultSet.TYPE_FORWARD_ONLY,TYPE_SCROLL_INSENSITIVE,TYPE_SCROLL_SENSITIVE
2) ResultSet.CONCUR_READ_ONLY CONCUR_UPDATABLE)
```
######Understanding Updatable ResultSets
```
rs.updateString("cname","newattr");
updateRow()
deleteRow()
refreshRow()
cancelRowUpdates()
insertRow()
```