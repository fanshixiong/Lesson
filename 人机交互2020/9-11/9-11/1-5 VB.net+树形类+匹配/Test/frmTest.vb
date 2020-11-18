Imports System.IO

Public Class frmTest
    Dim dir As clsDir
    Private Sub btnSeach_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnSeach.Click
        Dim path As String = GetFolder()
        dir = New clsDir(path)
        lstInfo.Items.Add(dir.FileCount())
        lstInfo.Items.Add(dir.FolderCount())
        dir.Output(lstInfo)
    End Sub

    Function GetFolder() As String
        Static lastSeclect As String = ""
        Dim dlg As New FolderBrowserDialog
        dlg.ShowNewFolderButton = True
        dlg.SelectedPath = lastSeclect
        If dlg.ShowDialog() = DialogResult.OK Then
            lastSeclect = dlg.SelectedPath
            Return dlg.SelectedPath
        End If
        Return ""
    End Function

    Private Sub btnSearchPattern_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles btnSearchPattern.Click
        Dim res As List(Of String) = dir.Search(txtPattern.Text)
        For i = 0 To res.Count - 1
            lstRes.Items.Add(res(i))
        Next
    End Sub
End Class
