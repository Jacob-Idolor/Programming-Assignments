<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">
  <html>
  <body>
  <h2>My Academic Planner </h2>
   <xsl:for-each select="catalog/semester">
<br></br>
<xsl:value-of select="@name"/>

   <table border="1">
     <tr bgcolor="#ffff00">
       <th style="text-align:center:">Catalog Number</th>
       <th style="text-align:center">Title</th>
       <th style="test-align:center">Prerequisites</th> 
     </tr>
     <xsl:for-each select="class">

<tr bgcolor="ffffff">
       <td align="center"><xsl:value-of select="department"/>
        <xsl:value-of select="number"/></td>
        <td align="center"><xsl:value-of select="title"/></td>
       <td align="center"><xsl:value-of select="preq"/></td>

</tr>
    </table>
  </body>
  </html>
</xsl:template>
</xsl:stylesheet>

