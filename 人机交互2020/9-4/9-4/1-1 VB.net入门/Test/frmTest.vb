Imports System.IO

Public Class frmTest

    Private Sub btnSeach_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnSeach.Click
        'lstInfo.Items.Clear()
        'lstInfo.Items.Add("aaaaa1")
        'lstInfo.Items.Add("aaaaa2")
        'lstInfo.Items.Add("aaaaa3")
        Dim path As String = "D:\0000人机交互"
        Dim files() As String = Directory.GetFiles(path)
        For i = 0 To files.Count - 1
            lstInfo.Items.Add(files(i))
        Next
        Dim dirs() As String = Directory.GetDirectories(path)
        For i = 0 To dirs.Count - 1
            lstInfo.Items.Add(dirs(i))
        Next
    End Sub
End Class
