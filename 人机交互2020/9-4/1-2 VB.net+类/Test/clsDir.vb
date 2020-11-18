Imports System.IO

Public Class clsDir
    Private files() As String
    Private dirs() As String

    Public Sub New(ByVal path As String)
        files = Directory.GetFiles(path)
        dirs = Directory.GetDirectories(path)
    End Sub
    Public Sub Output(ByVal lstInfo As ListBox)
        For i = 0 To files.Count - 1
            lstInfo.Items.Add(files(i))
        Next
        For i = 0 To dirs.Count - 1
            lstInfo.Items.Add(dirs(i))
        Next
    End Sub

End Class
