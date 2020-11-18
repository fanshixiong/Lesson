Imports System.IO

Public Class frmTest
    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        Dim laoZhang As TreeNode = tvFamily.Nodes.Add("laozhang")
        laoZhang.Nodes.Add("zhang1")
        Dim Zhang2 As TreeNode = laoZhang.Nodes.Add("zhang2")
        Zhang2.Nodes.Add("zhang2_1")
        Zhang2.Nodes.Add("zhang2_2")
        Zhang2.Nodes.Add("zhang2_3")
        laoZhang.Nodes.Add("zhang3")
        Dim laoWang As TreeNode = tvFamily.Nodes.Add("laoWang")
        Dim laoLi As TreeNode = tvFamily.Nodes.Add("laoLi")
    End Sub


End Class

