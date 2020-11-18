Imports System.IO

Public Class clsDir
    Private files() As String
    Private dirs() As clsDir

    Public Sub New(ByVal path As String)
        files = Directory.GetFiles(path)
        Dim folders() As String = Directory.GetDirectories(path)
        ReDim dirs(folders.Count - 1)
        For i = 0 To folders.Count - 1
            dirs(i) = New clsDir(folders(i))
        Next
    End Sub
    Public Sub Output(ByVal lstInfo As ListBox)
        For i = 0 To files.Count - 1
            lstInfo.Items.Add(files(i))
        Next
        For i = 0 To dirs.Count - 1
            dirs(i).Output(lstInfo)
        Next
    End Sub
    Public Function Depth() As Integer
        Return 0
    End Function
    Public Function FileCount() As Integer
        Dim ans As Integer = files.Count
        For i = 0 To dirs.Count - 1
            ans += dirs(i).FileCount()
        Next
        Return ans
    End Function
    Public Function FolderCount() As Integer
        Dim ans As Integer = dirs.Count
        For i = 0 To dirs.Count - 1
            ans += dirs(i).FolderCount()
        Next
        Return ans
    End Function
    'Private files() As String
    'Private dirs() As clsDir

    Public Function Search(ByVal pattern As String) As List(Of String)
        Dim res As New List(Of String)
        ' 访问节点
        For i = 0 To files.Count - 1
            If files(i).Contains(pattern) = True Then
                res.Add(files(i))
            End If
        Next
        ' 遍历子树
        For i = 0 To dirs.Count - 1
            Dim r1 As List(Of String) = dirs(i).Search(pattern)
            res.AddRange(r1)
        Next
        Return res
    End Function

End Class
