Imports System.IO

Public Class frmTest
    Dim Pcs As clsParentChilds
    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        Pcs = New clsParentChilds("tree.txt")
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Pcs.Output(tvFamily)
    End Sub


End Class

