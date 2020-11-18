Imports System.IO

Class ParentChild
    Public parent As String
    Public child As String

    Public Sub New(ByVal line As String)
        Dim words() As String = line.Split(" ")
        parent = words(0)
        child = words(1)
    End Sub
End Class


Public Class clsParentChilds
    Private PCs As List(Of ParentChild)

    Public Sub New(ByVal fname As String)
        PCs = New List(Of ParentChild)
        Dim fs As New FileStream(fname, FileMode.Open)
        Dim sr As New StreamReader(fs, System.Text.Encoding.Unicode)
        Dim n As Integer
        n = sr.ReadLine
        For i = 1 To n
            Dim line As String = sr.ReadLine()
            Dim pc As New ParentChild(line)
            PCs.Add(pc)
        Next
    End Sub
    Sub Output(ByVal tvfamily As TreeView)
        For i = 0 To PCs.Count - 1
            tvfamily.Nodes.Add(PCs(i).parent & "->" & PCs(i).child)
        Next
    End Sub
End Class
