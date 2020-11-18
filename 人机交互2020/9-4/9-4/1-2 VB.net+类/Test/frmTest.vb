Imports System.IO

Public Class frmTest

    Private Sub btnSeach_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnSeach.Click
        Dim path As String = "D:\0000人机交互"
        Dim dir As New clsDir(path)
        dir.Output(lstInfo)
    End Sub
End Class
