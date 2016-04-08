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
#####Managing transactions
######
```
conn.setAutoCommit(false);
......
if...conn.commit();
else...conn.rollback()
```
#####BLOB and CLOB(long text)
######
mysql->Resume LongText  
oracle->Resume CLOB   
######Clob
```
String path = "c:/test.txt";
File file = new File(path);
FileReader reader = new FileReader(file);       //Here throws FileNotFoundException
stmt.setCharacterStream(1,reader,(int)file.length());      //syntax
stmt.executeUpdate();
```
######Blob
```
String path = "c:/1.jpg";
File file = new File(path);
FileInputStream fis = new FileInputStream(file);
stmt.setBinaryStream(1,fis,fis.available());      //syntax, IOException
stmt.executeUpdate();
```