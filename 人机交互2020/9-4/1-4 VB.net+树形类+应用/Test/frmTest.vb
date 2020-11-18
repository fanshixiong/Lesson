Imports System.IO

Public Class frmTest

    Private Sub btnSeach_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnSeach.Click
        Dim path As String = "D:\\0000人机交互技术\\9-4\\1 VB.net入门\\Test"
        Dim dir As New clsDir(path)
        lstInfo.Items.Add(dir.FileCount())
        lstInfo.Items.Add(dir.FolderCount())
        dir.Output(lstInfo)
    End Sub
End Class
