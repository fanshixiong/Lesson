Imports System.IO

Public Class frmTest
    Dim GenX As clsGenXY, GenY As clsGenXY
    Dim p As clsPoint
    Dim WithEvents tmTicker As Timer  ' !!!!!

    Private Sub frmTest_Load(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles MyBase.Load
        GenX = New clsGenXY(100, 200, 50, 80)
        GenY = New clsGenXY(200, 100, 50, 100)
        p = New clsPoint(200, 200)
        p.MoveTo(GenX.GetX(), GenY.GetY())
        tmTicker = New Timer
        tmTicker.Interval = 100
        tmTicker.Enabled = False
    End Sub

    Private Sub Button1_Click(ByVal sender As System.Object, ByVal e As System.EventArgs) Handles Button1.Click
        tmTicker.Enabled = Not tmTicker.Enabled
    End Sub

    Private Sub tmTicker_Tick(ByVal sender As Object, ByVal e As System.EventArgs) Handles tmTicker.Tick
        GenX.DoTick() : GenY.DoTick()
        p.LineTo(GenX.GetX(), GenY.GetY())
        Dim g As Graphics = picCanvas.CreateGraphics
        GenX.Draw(g) : GenY.Draw(g)
        p.Draw(g)
    End Sub

End Class

