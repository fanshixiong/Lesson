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
    Private Root As TreeNode

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
        CreateTree()
    End Sub
    Sub CreateTree()
        Root = New TreeNode(PCs(0).parent)
        Root.Nodes.Add(PCs(0).child)
        For i = 1 To PCs.Count - 1
            Dim parent As TreeNode = Search(Root, PCs(i).parent)
            parent.Nodes.Add(PCs(i).child)
        Next
    End Sub
    Private Function Search(ByVal p As TreeNode, ByVal key As String) As TreeNode
        If p.Text = key Then Return p
        For i = 0 To p.Nodes.Count - 1
            Dim q As TreeNode = Search(p.Nodes(i), key)
            If q IsNot Nothing Then
                Return q
            End If
        Next
        Return Nothing
    End Function

    Sub Output(ByVal tvfamily As TreeView)
        tvfamily.Nodes.Add(Root)
    End Sub


End Class
