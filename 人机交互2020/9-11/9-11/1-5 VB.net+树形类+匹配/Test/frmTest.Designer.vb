﻿<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmTest
    Inherits System.Windows.Forms.Form

    'Form 重写 Dispose，以清理组件列表。
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Windows 窗体设计器所必需的
    Private components As System.ComponentModel.IContainer

    '注意: 以下过程是 Windows 窗体设计器所必需的
    '可以使用 Windows 窗体设计器修改它。
    '不要使用代码编辑器修改它。
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.btnSeach = New System.Windows.Forms.Button()
        Me.lstInfo = New System.Windows.Forms.ListBox()
        Me.btnSearchPattern = New System.Windows.Forms.Button()
        Me.lstRes = New System.Windows.Forms.ListBox()
        Me.txtPattern = New System.Windows.Forms.TextBox()
        Me.SuspendLayout()
        '
        'btnSeach
        '
        Me.btnSeach.Location = New System.Drawing.Point(20, 16)
        Me.btnSeach.Margin = New System.Windows.Forms.Padding(4)
        Me.btnSeach.Name = "btnSeach"
        Me.btnSeach.Size = New System.Drawing.Size(100, 31)
        Me.btnSeach.TabIndex = 0
        Me.btnSeach.Text = "btnSeach"
        Me.btnSeach.UseVisualStyleBackColor = True
        '
        'lstInfo
        '
        Me.lstInfo.FormattingEnabled = True
        Me.lstInfo.ItemHeight = 16
        Me.lstInfo.Location = New System.Drawing.Point(13, 65)
        Me.lstInfo.Margin = New System.Windows.Forms.Padding(4)
        Me.lstInfo.Name = "lstInfo"
        Me.lstInfo.Size = New System.Drawing.Size(597, 212)
        Me.lstInfo.TabIndex = 1
        '
        'btnSearchPattern
        '
        Me.btnSearchPattern.Location = New System.Drawing.Point(20, 285)
        Me.btnSearchPattern.Margin = New System.Windows.Forms.Padding(4)
        Me.btnSearchPattern.Name = "btnSearchPattern"
        Me.btnSearchPattern.Size = New System.Drawing.Size(157, 31)
        Me.btnSearchPattern.TabIndex = 0
        Me.btnSearchPattern.Text = "btnSearchPattern"
        Me.btnSearchPattern.UseVisualStyleBackColor = True
        '
        'lstRes
        '
        Me.lstRes.FormattingEnabled = True
        Me.lstRes.ItemHeight = 16
        Me.lstRes.Location = New System.Drawing.Point(13, 323)
        Me.lstRes.Margin = New System.Windows.Forms.Padding(4)
        Me.lstRes.Name = "lstRes"
        Me.lstRes.Size = New System.Drawing.Size(597, 116)
        Me.lstRes.TabIndex = 1
        '
        'txtPattern
        '
        Me.txtPattern.Location = New System.Drawing.Point(296, 290)
        Me.txtPattern.Name = "txtPattern"
        Me.txtPattern.Size = New System.Drawing.Size(123, 26)
        Me.txtPattern.TabIndex = 2
        Me.txtPattern.Text = ".sln"
        '
        'frmTest
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(8.0!, 16.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(724, 461)
        Me.Controls.Add(Me.txtPattern)
        Me.Controls.Add(Me.lstRes)
        Me.Controls.Add(Me.lstInfo)
        Me.Controls.Add(Me.btnSearchPattern)
        Me.Controls.Add(Me.btnSeach)
        Me.Font = New System.Drawing.Font("宋体", 12.0!, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, CType(134, Byte))
        Me.Margin = New System.Windows.Forms.Padding(4)
        Me.Name = "frmTest"
        Me.Text = "Form1"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents btnSeach As System.Windows.Forms.Button
    Friend WithEvents lstInfo As System.Windows.Forms.ListBox
    Friend WithEvents btnSearchPattern As System.Windows.Forms.Button
    Friend WithEvents lstRes As System.Windows.Forms.ListBox
    Friend WithEvents txtPattern As System.Windows.Forms.TextBox

End Class
